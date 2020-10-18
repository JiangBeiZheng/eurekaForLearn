package learnEntity;

public class TestEntity {
    private String name;
    private String agd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgd() {
        return agd;
    }

    public void setAgd(String agd) {
        this.agd = agd;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "name='" + name + '\'' +
                ", agd='" + agd + '\'' +
                '}';
    }
}
