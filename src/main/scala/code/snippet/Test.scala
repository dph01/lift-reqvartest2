package code.snippet
import scala.xml.Text
import net.liftweb.common.Logger
import net.liftweb.http.{SHtml, S, RequestVar, DispatchSnippet}
import net.liftweb.mapper.MappedField.mapToType
import net.liftweb.util.AnyVar.whatVarIs
import net.liftweb.util.Helpers.strToCssBindPromoter
import net.liftweb.util.IterableConst.{itNodeSeqFunc, boxNodeSeq}
import net.liftweb.http.js.JsCmds.{Alert}
import net.liftweb.http.js.jquery.JqJsCmds.ModalDialog
import net.liftweb.http.js.jquery.JqJsCmds.Unblock
import scala.xml.NodeSeq
import net.liftweb.http.js.JsCmds.{Alert,SetHtml,Noop}
import net.liftweb.http.js.JE.JsRaw
import net.liftweb.http.js.JsObj
import net.liftweb.common.Full
import net.liftweb.common.Box
import net.liftweb.http.js.JsCmd
import net.liftweb.common.Empty

class Test {

  object name extends RequestVar[String]("initial value")
    
  def test = {
    "#name" #> name.is &
    "#page2" #> SHtml.link("/test2", () => { name("fred") }, Text("Go to Page 2") )
  }  
  
  def test2 = {
    "#name" #> name.is &
    "#page3" #> SHtml.link("/test3", () => (), Text("Go to Page 3") )
  }
  
   def test3 = {
    "#name" #> name.is &
    "#page2" #> SHtml.link(S.referer.openOr("/"), () => (), Text("Back to Page 2") )
  }
} 