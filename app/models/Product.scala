package models

case class Product(id: Int, name: String, price: Double, productType: String) {
  override def equals(that: Any): Boolean = ???
}

object Product {

  val productList = Seq(
    Product(1, "Tomato", 10.10, "VEGETABLE"),
    Product(2, "Sandwich with ham", 5.10, "SANDWICHES"),
    Product(3, "Ice cream", 3.11, "SWEET"),
    Product(4, "Sandwich", 4.95, "SANDWICHES"),
    Product(5, "Pepper", 2.99, "SPICES"),
    Product(6, "Chicken", 13.29, "MEAT"),
  )

  def getProductById(id: Int): Seq[Product] = {
    productList.filter(a => a.id.equals(id))
  }

  def getProductByName(name: String): Seq[Product] = {
    productList.filter(a => a.name.contains(name))
  }

  def getProductsByType(productType: String): Seq[Product] = {
    productList.filter(a => a.productType == productType)
  }
}