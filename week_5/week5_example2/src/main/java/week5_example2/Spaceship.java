package week5_example2;

public class Spaceship {
    private String name;
    private boolean isFlying;
    private Engine engine;
    private ArrayList<Cargo> cargoList;

    public Spaceship(String name, Engine engine) {
        this.name = name;
        this.engine = engine;
        this.isFlying = false;
        this.cargoList = new ArrayList<>();
    }

    public void addCargo(Cargo cargo) {
        cargoList.add(cargo);
    }

    public boolean startJourney() {
        if (engine.getFuelLevel() > 0 && !cargoList.isEmpty()) {
            isFlying = engine.start();
            return isFlying;
        }
        return false;
    }

    public String getStatus() {
        StringBuilder status = new StringBuilder();
        status.append("Spaceship: ").append(name)
                .append("\nStatus: ").append(isFlying ? "Flying" : "Grounded")
                .append("\nFuel Level: ").append(engine.getFuelLevel())
                .append("\nCargo Items: ").append(cargoList.size());

        return status.toString();
    }
}
