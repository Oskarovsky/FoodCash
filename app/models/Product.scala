package models

case class Product(id: Int, name: String, price: Double, productType: String) {
  override def equals(that: Any): Boolean = ???
}

object Product {

  private var productList: List[Product] = List()

  def all: List[Product] = {
    productList
  }

  def add(productName: String): Unit = {
    val newId: Int = productList.last.id + 1
    productList = productList ++ List(Product(newId, productName, 0, null))
  }

  def delete(productId: Int) = {
    productList = productList.filterNot(product => product.id == product.id)
  }
}