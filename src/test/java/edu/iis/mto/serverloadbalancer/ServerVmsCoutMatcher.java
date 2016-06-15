package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class ServerVmsCoutMatcher extends TypeSafeMatcher<Server> {

	private int expectedVmsCount;

	public ServerVmsCoutMatcher(int expectedVmsCount) {
		this.expectedVmsCount = expectedVmsCount;

	}

	public void describeTo(Description description) {
		description.appendText("A server with vms count of").appendValue(expectedVmsCount);
	}

	@Override
	protected void describeMismatchSafely(Server item, Description description) {
	
		description.appendText("A server with vms count of").appendValue(item.countVms());
	}

	@Override
	protected boolean matchesSafely(Server server) {
	
		return expectedVmsCount == server.countVms();
	}

}