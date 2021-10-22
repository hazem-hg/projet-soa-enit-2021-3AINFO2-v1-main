import java.util.*;

class Product 
{
  	private int m_prodID;
	private String m_prodName;
	
	Product() {}
	Product(int newID, String newName)	// Overload the constructor
	{
		m_prodID = newID;
		m_prodName = newName;
	}

	// Methods to get and set the values
	public int GetID()  {
		return m_prodID;
	}
	public String GetName() {
		return m_prodName;
	}
	public void SetID(int newID) {
		m_prodID = newID;
	}
	public void SetName(String newName) {
		m_prodName = newName;
	}

	// Method to print out our data
	public void PrintValues() {
		System.out.println(m_prodID + " " + m_prodName);
	}

	// New method to see if two products are equal. 
	public boolean equals(Object otherProduct)
	{
		Product p = (Product) otherProduct;
		return (this.m_prodID == p.m_prodID);
	}
}

//merge test 