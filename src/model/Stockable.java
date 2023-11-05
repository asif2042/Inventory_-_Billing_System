package model;

public interface Stockable {

	void addStock(int quantity);
    void removeStock(int quantity);
    void editStock(int quantity);
}
