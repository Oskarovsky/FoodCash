package controllers

import play.api.mvc.{AbstractController, AnyContent, ControllerComponents, Request}
import play.twirl.api.Html

import javax.inject.{Inject, Singleton}

@Singleton
class PurchaseController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

    def getAllPurchases = Action { implicit request: Request[AnyContent] =>
      val newContent = Html("<div>List of all purchases<div>")
      Ok(views.html.purchase("Purchase manager")(newContent))
    }

}
