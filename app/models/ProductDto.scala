package models

import com.fasterxml.jackson.annotation.JsonFormat
import play.api.libs.json.Json


case class ProductDto(id: Int, description: String) {


  override def equals(that: Any): Boolean = ???
}
