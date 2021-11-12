package controllers

import models.Purchase
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents, Request}
import play.twirl.api.Html

import javax.inject.{Inject, Singleton}

@Singleton
class PurchaseController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def purchasesList: Action[AnyContent] = Action {
    val purchases = Purchase.getPurchasesList()
    if (purchases.isEmpty) {
      NoContent
    } else {
      Ok(views.html.purchase(purchases))
    }
  }

}
