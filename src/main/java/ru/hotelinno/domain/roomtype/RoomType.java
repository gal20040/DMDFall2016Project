package ru.hotelinno.domain.roomtype;

public final class RoomType {
    private int typeID;
    private String typeName;
    private int price;

    public int getPrice() {
        return price;
    }

    public int getTypeID() {
        return typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
