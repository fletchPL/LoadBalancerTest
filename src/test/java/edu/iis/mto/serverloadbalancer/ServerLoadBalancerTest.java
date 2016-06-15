package edu.iis.mto.serverloadbalancer;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matcher;
import org.junit.Test;

public class ServerLoadBalancerTest {
	@Test
	public void itCompiles() {
		assertThat(true, equalTo(true));
	}

@Test
public void balancingServerWithNoVms_serverStayEmpty()
{
	Server theServer = a(ServerBuilder.server().withCapacity(1));
	
	balancing(aServerListWith(theServer), anEmptyListOfVms());
	
	assertThat(theServer, CurrentLoadPercentageMatcher.hasLoadPercentageOf(0.0d));
}

@Test // test 2
public void balancingOneServerWithOneSlotCapacity_andOneVm_fillsServerWithTheVm(){
	Server theServer = a(ServerBuilder.server().withCapacity(1));
	
	Vm theVm = a(VmBuilder.vm().ofSize(1));
	balancing(aServerListWith(theServer), aVmsListWiht(theVm));
	
	
	assertThat(theServer, CurrentLoadPercentageMatcher.hasLoadPercentageOf(100.0d));
	assertThat("Server should contain the vm", theServer.contains(theVm));

}
@Test
//test 3
public void balancingOneServerWithTenSlotsCapacity_andOneSlotVm_fillsTheServerWithTenPercent()
{
	Server theServer = a(ServerBuilder.server().withCapacity(10));
	
	Vm theVm = a(VmBuilder.vm().ofSize(1));
	balancing(aServerListWith(theServer), aVmsListWiht(theVm));
	
	
	assertThat(theServer, CurrentLoadPercentageMatcher.hasLoadPercentageOf(10.0d));
	assertThat("Server should contain the vm", theServer.contains(theVm));
}


@Test //test 4

public void balancingTheServerWithEnoughRoom_fillsTheServerWithAllVms()
{
	Server theServer = a(ServerBuilder.server().withCapacity(100));
	
	Vm theFirstVm = a(VmBuilder.vm().ofSize(1));
	Vm theSecendVm = a(VmBuilder.vm().ofSize(1));
	balancing(aServerListWith(theServer), aVmsListWiht(theFirstVm, theSecendVm));
	
	
	assertThat(theServer, hasAVmsCountOf(2));
	assertThat("Server should contain the FirstVm", theServer.contains(theFirstVm ));
	assertThat("Server should contain the SecondVm ", theServer.contains(theSecendVm ));
}




private Matcher<? super Server> hasAVmsCountOf(int expectedVmsCount) {
	
	return new ServerVmsCoutMatcher(expectedVmsCount);
}

private void balancing(Server[] servers, Vm[] vms) {
	new ServerLoadBalancer().balance(servers,vms);
	
}

private Vm[] anEmptyListOfVms() {
	// TODO Auto-generated method stub
	return new Vm[0];
}
private <T> T a(Builder<T> builder){
	return builder.build();
}


private Server[] aServerListWith(Server... servers) {
	// TODO Auto-generated method stub
	return servers;
}


private Vm[] aVmsListWiht(Vm... vms) {
	
	return vms;
}

}
