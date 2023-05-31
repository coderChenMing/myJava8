package com.learn.java8.bean;

/**
 * Project: myJava8
 * File Created at 2022-04-12 09:31:9:31
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type People.java
 * @Description
 * @date 2022/4/12 9:31
 */
public class People implements Cloneable {
    private Integer id;
    private String name;
    private Address address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * 重写clone方法
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        People people = (People) o;

        if (getId() != null ? !getId().equals(people.getId()) : people.getId() != null) return false;
        if (getName() != null ? !getName().equals(people.getName()) : people.getName() != null) return false;
        return getAddress() != null ? getAddress().equals(people.getAddress()) : people.getAddress() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        return result;
    }
}
