package edu.iis.mto.serverloadbalancer;

public class ServerBuilder implements Builder<Server>{

	private int capacity;
	private double initalLoad;
	public ServerBuilder withCapacity(int capacity) {
		// TODO Auto-generated method stub
		this.capacity = capacity;
		return this;
	}
	public Server build() {
		// TODO Auto-generated method stub
		return new Server(capacity);
	}

	public static ServerBuilder server() {
		// TODO Auto-generated method stub
		return new ServerBuilder();
	}
	public ServerBuilder wothCurrentLoadOf(double initalLoad) {
		
		this.initalLoad = initalLoad;
		return null;
	}
}
