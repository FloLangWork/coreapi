package de.flolang.coreapi.bungee;

public abstract class CorePlugin {

    protected String name;

    public CorePlugin(String name) {
        this.name = name;
    }

    public abstract void enabled();
    public abstract void disabled();

    public String getName() {
        return name;
    }
}