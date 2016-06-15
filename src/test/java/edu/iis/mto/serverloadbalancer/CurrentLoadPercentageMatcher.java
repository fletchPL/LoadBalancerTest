package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class CurrentLoadPercentageMatcher extends TypeSafeMatcher<Server>{

	private double expectedLoadPercentage;
	
	public CurrentLoadPercentageMatcher(double expectedLoadPercentage) {
	
		this.expectedLoadPercentage = expectedLoadPercentage;
	}

	public void describeTo(Description description) {
		description.appendText(" a server with load percenttage of ").appendValue(expectedLoadPercentage);
		
	}

	@Override
	protected boolean matchesSafely(Server server) {
		
		return twoDoubleAreEquile(expectedLoadPercentage, server.currentLoadPercetage);
	}

	private boolean twoDoubleAreEquile(double d1, double d2) {
		return d1 == d2 || Math.abs(d1 - d2)< 0.01d;
	}
	

public static CurrentLoadPercentageMatcher hasLoadPercentageOf(double expectedLoadPercentage) {
	// TODO Auto-generated method stub
	//koment
	return new CurrentLoadPercentageMatcher(expectedLoadPercentage);
}
}
