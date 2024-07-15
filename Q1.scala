object InventoryManagement {

  def getProductList(): List[String] = {
    import scala.io.StdIn.readLine
    var productList: List[String] = List()
    var input: String = ""

    println("Enter product names (type 'done' to finish):")
    while (input != "done") {
      input = readLine()
      if (input != "done" && input.nonEmpty) {
        productList = productList :+ input
      }
    }
    productList
  }

  def printProductList(productList: List[String]): Unit = {
    println("Product List:")
    for ((product, index) <- productList.zipWithIndex) {
      println(s"${index + 1}. $product")
    }
  }

  def getTotalProducts(productList: List[String]): Int = {
    productList.length
  }

  def main(args: Array[String]): Unit = {
    val products = getProductList()

    printProductList(products)

    println(s"Total number of products: ${getTotalProducts(products)}")
  }
}