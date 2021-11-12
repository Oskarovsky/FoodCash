package controllers

import models.{Product, ProductDto}
import play.api.libs.json.Json
import play.api.mvc._

import javax.inject.{Inject, Singleton}

@Singleton
class ProductController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  implicit val productListJson = Json.format[Product]

  implicit val productDtoJson = Json.format[ProductDto]

  val productList = Seq(
    Product(1, "Tomato", 10.10, "VEGETABLE"),
    Product(2, "Sandwich with ham", 5.10, "SANDWICHES"),
    Product(3, "Ice cream", 3.11, "SWEET"),
    Product(4, "Sandwich", 4.95, "SANDWICHES"),
    Product(5, "Pepper", 2.99, "SPICES"),
    Product(6, "Chicken", 13.29, "MEAT"),
  )

  /* VIEW */
  def productsList: Action[AnyContent] = Action {
    Ok(views.html.productList(productList))
  }

  def productInfo(productId: Int): Action[AnyContent] = Action {
    Ok(views.html.product(Product.getProductById(productId).head))
  }

  /* API */

  def getProductsList: Action[AnyContent] = Action {
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

  def getProductsByType(productType: String): Action[AnyContent] = Action {
    val foundProduct = Product.getProductsByType(productType)
    if (foundProduct.isEmpty) {
      NoContent
    } else {
      Ok(Json.toJson(foundProduct))
    }
  }


}
