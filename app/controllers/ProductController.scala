package controllers

import models.{Product, ProductDto}
import play.api.libs.json.Json

import javax.inject.{Inject, Singleton}
import play.api.mvc._

import scala.collection.mutable.ListBuffer
import scala.concurrent._

@Singleton
class ProductController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  implicit val productListJson = Json.format[Product]

  implicit val productDtoJson = Json.format[ProductDto]

//  private val productList = new ListBuffer[Product]
//  productList += Product(1, "Tomato")
//  productList += Product(2, "Sandwich")

  val productList = Seq(
    Product(1, "Tomato", 10.10, "VEGETABLE"),
    Product(2, "Sandwich with ham", 5.10, "SANDWICHES"),
    Product(3, "Ice cream", 3.11, "SWEET"),
    Product(4, "Sandwich", 4.95, "SANDWICHES"),
    Product(5, "Pepper", 2.99, "SPICES"),
    Product(6, "Chicken", 13.29, "MEAT"),
  )

  def getProducts: Action[AnyContent] = Action {
    if (productList.isEmpty) {
      NoContent
    } else {
      Ok(Json.toJson(productList))
    }
  }

  def getProductById(productId: Int): Action[AnyContent] = Action {
    val foundProduct = productList.find(_.id == productId)
    foundProduct match {
      case Some(product) => Ok(Json.toJson(product))
      case None => NotFound
    }
  }

  def getProductByName(name: String): Seq[Product] = {
    productList.filter(a => a.name.contains(name))
  }

  def getProductsByType(productType: String): Seq[Product] = {
    productList.filter(a => a.productType == productType)
  }

  def addProduct() = Action(parse.formUrlEncoded) {
    implicit request => {
      Product.add(request.body("productName").head)
      Redirect(routes.ProductController.getProducts)
    }
  }

  def deleteProduct(id: Int) = Action {
    Product.delete(id)
    Ok
  }




}
