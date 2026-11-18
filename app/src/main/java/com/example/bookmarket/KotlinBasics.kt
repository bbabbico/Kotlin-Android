package com.example.bookmarket

import android.util.Log

fun runKotlinBasics() {
    variableExample()
    dataTypeExample()
    operatorExample()
    ifExample()
    whenExample()
    loopExample()
    functionExample()
    collectionExample()
    oopExample()
    nullExample()
    scopeFunctionExample()
}

fun variableExample() {
    var stock = 20
    stock = 25
    Log.d("코틀린 : 가변 변수 var", "도서 재고는 $stock 권")

    val bookTitle = "코틀린 입문"
    Log.d("코틀린 : 불변 변수 val", "도서 제목은 $bookTitle")

    lateinit var publisher: String
    publisher = "한빛아카데미"
    Log.d("코틀린 : lateinit var", "출판사는 $publisher")

    Log.i("코틀린 : 로그 레벨", "INFO 레벨 로그 (Log.i)")
}

fun dataTypeExample() {
    val stock = 1
    val totalSales = 3000000000
    val rating: Byte = 5
    val pages: Short = 320
    val price: Int = 20000
    val isbnNo = 9788900000000L
    Log.d("코틀린 : 정수 자료형", "Int : $stock")
    Log.d("코틀린 : 정수 자료형", "Long : $totalSales")
    Log.d("코틀린 : 정수 자료형", "Byte : $rating")
    Log.d("코틀린 : 정수 자료형", "Short : $pages")
    Log.d("코틀린 : 정수 자료형", "Int : $price")
    Log.d("코틀린 : 정수 자료형", "Long : $isbnNo")

    val discountRate = 0.1F
    val avgScore = 4.5
    Log.d("코틀린 : 실수 자료형", "Float : $discountRate")
    Log.d("코틀린 : 실수 자료형", "Double : $avgScore")

    val isSoldOut: Boolean = false
    Log.d("코틀린 : 부울린 자료형", "Boolean : $isSoldOut")

    val grade: Char = 'A'
    Log.d("코틀린 : 문자 자료형", "Char : $grade")

    val title: String = "Kotlin\n"
    val author: String = "홍길동"
    Log.d("코틀린 : 문자열 자료형", "String : $title")
    Log.d("코틀린 : 문자열 자료형", "String : $author")
    Log.d("코틀린 : 문자열 자료형", "제목\t\"코틀린 입문\"\n가격\t\$20000 \\ 재고 5권")

    val prices: IntArray = intArrayOf(15000, 18000, 20000, 22000, 25000)
    Log.d("코틀린 : 배열 자료형", "3번째 도서 가격 : ${prices[2]}")

    val qty: Int = 100
    val bigQty: Long = qty.toLong()
    Log.d("코틀린 : 자료형 변환", "Int : $qty")
    Log.d("코틀린 : 자료형 변환", "Long : $bigQty")
}

fun operatorExample() {
    val price = 20000
    val qty = 3
    Log.d("코틀린 : 산술 연산자", "price + qty = ${price + qty}")
    Log.d("코틀린 : 산술 연산자", "price - qty = ${price - qty}")
    Log.d("코틀린 : 산술 연산자", "price / qty = ${price / qty}")
    Log.d("코틀린 : 산술 연산자", "price * qty = ${price * qty}")
    Log.d("코틀린 : 산술 연산자", "price % qty = ${price % qty}")

    val budget = 50000
    val total = price * qty
    Log.d("코틀린 : 비교 연산자", "total > budget = ${total > budget}")
    Log.d("코틀린 : 비교 연산자", "total < budget = ${total < budget}")
    Log.d("코틀린 : 비교 연산자", "total >= budget = ${total >= budget}")
    Log.d("코틀린 : 비교 연산자", "total <= budget = ${total <= budget}")
    Log.d("코틀린 : 비교 연산자", "total == budget = ${total == budget}")
    Log.d("코틀린 : 비교 연산자", "total != budget = ${total != budget}")

    var cart = 10000
    val add = 5000
    cart += add; Log.d("코틀린 : 할당 연산자", "cart += add => $cart")
    cart -= add; Log.d("코틀린 : 할당 연산자", "cart -= add => $cart")
    cart *= 2;   Log.d("코틀린 : 할당 연산자", "cart *= 2 => $cart")
    cart /= 4;   Log.d("코틀린 : 할당 연산자", "cart /= 4 => $cart")
    cart %= 3000; Log.d("코틀린 : 할당 연산자", "cart %= 3000 => $cart")

    var count = 1
    Log.d("코틀린 : 증감 연산자", "++count = ${++count}")
    Log.d("코틀린 : 증감 연산자", "--count = ${--count}")

    val isMember = true
    val hasCoupon = false
    Log.d("코틀린 : 논리 연산자", "isMember && hasCoupon = ${isMember && hasCoupon}")
    Log.d("코틀린 : 논리 연산자", "isMember || hasCoupon = ${isMember || hasCoupon}")
    Log.d("코틀린 : 논리 연산자", "!hasCoupon = ${!hasCoupon}")
}

fun ifExample() {
    val stock = 3
    if (stock > 0) {
        Log.d("코틀린 : if 조건문", "재고 $stock 권, 구매 가능")
    }

    val qty = 10
    if (qty % 2 == 0) {
        Log.d("코틀린 : if-else 조건문", "주문 수량 $qty 은 짝수")
    } else {
        Log.d("코틀린 : if-else 조건문", "주문 수량 $qty 은 홀수")
    }

    val left = -10
    val result: String = if (left > 0) {
        "재고 $left 권 남음"
    } else if (left == 0) {
        "품절"
    } else {
        "재고 오류($left)"
    }
    Log.d("코틀린 : if-else if 조건문", result)

    val price = 25000
    val isMember = true
    val msg: String = if (price >= 20000) {
        if (isMember) "회원 + 2만원 이상: 무료배송, 10% 할인" else "2만원 이상: 무료배송"
    } else {
        if (isMember) "회원: 5% 할인" else "할인 없음"
    }
    Log.d("코틀린 : 중첩 if 조건문", msg)
}

fun whenExample() {
    val category = 2
    val result: String = when (category) {
        1 -> "소설"
        2 -> "IT/프로그래밍"
        3 -> "경제/경영"
        4 -> "자기계발"
        5 -> "만화"
        else -> "알 수 없는 분류"
    }
    Log.d("코틀린 : when 조건문", result)

    val day = 6
    val delivery = when (day) {
        1, 2, 3, 4, 5 -> "평일 배송"
        6, 7 -> "주말 배송 없음"
        else -> "잘못된 요일"
    }
    Log.d("코틀린 : when 응용", delivery)

    val price = 18000
    val priceRange = when (price) {
        in 0..9999 -> "1만원 미만"
        in 10000..19999 -> "1만원대"
        !in 0..100000 -> "가격 오류"
        else -> "2만원 이상"
    }
    Log.d("코틀린 : when 응용", priceRange)
}

fun loopExample() {
    for (i in 1..5) {
        Log.d("코틀린 : for 반복문", "도서 번호 $i")
    }

    for (i in 5 downTo 1) {
        Log.d("코틀린 : for 반복문", "역순 도서 번호 : $i")
    }

    for (i in 5 downTo 1 step 2) {
        Log.d("코틀린 : for 반복문", "2칸씩 역순 : $i")
    }

    val stocks = arrayOf(1, 2, 3, 4, 5)
    for (s in stocks) {
        if (s % 2 == 1) {
            Log.d("코틀린 : for 반복문", "홀수 재고 : $s")
        }
    }

    for (i in stocks.indices) {
        Log.d("코틀린 : for 반복문", "stocks[$i] : ${stocks[i]}")
    }

    var i = 0
    while (i <= 5) {
        Log.d("코틀린 : while 반복문", "반복 변수 : $i")
        i++
    }

    var j = 10
    do {
        Log.d("코틀린 : do-while 반복문", "반복 변수 : $j")
        j++
    } while (j <= 5)
}

fun totalPrice(price: Int, qty: Int = 1): Int {
    val total = price * qty
    return total
}

fun printTotal(price: Int, qty: Int = 1): Unit {
    Log.d("코틀린 : 사용자 정의 함수", "$price * $qty = ${price * qty}")
}

fun functionExample() {
    val price = 15000
    val qty = 3
    Log.d("코틀린 : 사용자 정의 함수", "$price * $qty = ${totalPrice(price, qty)}")

    Log.d("코틀린 : 사용자 정의 함수", "$price * 1 = ${totalPrice(price)}")

    printTotal(price, qty)

    Log.d("코틀린 : 사용자 정의 함수", "이름 있는 인자 = ${totalPrice(qty = 2, price = 18000)}")

    val point = 26
    val unit = 3
    Log.d("코틀린 : 표준 라이브러리 함수", "$point % $unit = ${point.rem(unit)}")
}

fun collectionExample() {
    val titles = listOf("코틀린 입문", "자바 입문", "안드로이드 프로그래밍", "알고리즘", "자료구조")
    val tags = setOf("IT", "IT", "프로그래밍", "입문", "입문")
    val books = mapOf(1 to "코틀린 입문", 2 to "자바 입문", 3 to "안드로이드 프로그래밍")

    Log.d("코틀린 : 컬렉션", "불변 리스트: $titles")
    Log.d("코틀린 : 컬렉션", "첫 번째 도서: ${titles[0]}")
    Log.d("코틀린 : 컬렉션", "불변 셋: $tags")
    Log.d("코틀린 : 컬렉션", "셋에 'IT' 포함 여부: ${"IT" in tags}")
    Log.d("코틀린 : 컬렉션", "불변 맵: $books")
    Log.d("코틀린 : 컬렉션", "맵에서 key 2의 값: ${books[2]}")

    val cart = mutableListOf("코틀린 입문", "자바 입문")
    val cartIds = mutableSetOf(6, 10)
    val stock = mutableMapOf("코틀린 입문" to 5, "자바 입문" to 3)

    Log.d("코틀린 : 컬렉션", "초기 장바구니: $cart / $cartIds / $stock")

    cart[0] = "코틀린 완벽 가이드"
    cart.add("알고리즘")
    cartIds.add(2)
    cartIds.add(5)
    stock["자바 입문"] = 2
    stock["알고리즘"] = 7

    Log.d("코틀린 : 컬렉션", "변경 후 ------------------------------")
    Log.d("코틀린 : 컬렉션", "변경된 리스트: $cart")
    Log.d("코틀린 : 컬렉션", "변경된 셋: $cartIds")
    Log.d("코틀린 : 컬렉션", "변경된 맵: $stock")
}

private const val OOP_TAG = "코틀린 : 객체 지향 프로그래밍"

class Member {
    var name: String = ""
    var age: Int = 0
    var gender: Char = 'M'

    fun printMemberInfo() {
        Log.d(OOP_TAG, "Member 이름 : $name")
        Log.d(OOP_TAG, "Member 나이 : $age")
        Log.d(OOP_TAG, "Member 성별 : $gender")
    }
}

class Book(bookId: String, bookTitle: String) {
    val id: String
    var title: String

    init {
        id = bookId
        title = bookTitle
        Log.d(OOP_TAG, "Book 아이디 : $id")
        Log.d(OOP_TAG, "Book 제목 : $title")
    }
}

class Author {
    var name: String
    var bookCount: Int

    init {
        Log.d(OOP_TAG, "Author 초기화 블록")
    }

    constructor(aname: String, count: Int) {
        this.name = aname
        this.bookCount = count
        Log.d(OOP_TAG, "Author 이름 : $name")
        Log.d(OOP_TAG, "Author 저서 수 : $bookCount")
    }

    constructor(aname: String) : this(aname, 0)
}

data class BookInfo(val title: String, val price: Int)

open class Product {
    open fun describe(): String = "상품"
}

class PaperBook : Product() {
    override fun describe(): String = "종이책"
}

interface Deliverable {
    fun deliver(): String
    fun track(): String = "배송 조회 중"
}

class OrderedBook : Deliverable {
    override fun deliver(): String = "택배 발송"
}

abstract class Payment {
    abstract fun pay(): String
}

class CardPayment : Payment() {
    override fun pay(): String = "카드 결제"
}

open class BaseBook {
    open val name: String = "도서"

    open fun format(): String = "일반 도서"

    constructor() {
        Log.d(OOP_TAG, "BaseBook 생성자 호출")
    }
}

class EBook : BaseBook {
    override val name: String = "전자책"

    override fun format(): String = "PDF/EPUB"

    fun printNames() {
        Log.d(OOP_TAG, "this.name = ${this.name}")
        Log.d(OOP_TAG, "super.name = ${super.name}")
    }

    fun callFormatMethods() {
        Log.d(OOP_TAG, "this.format() = ${this.format()}")
        Log.d(OOP_TAG, "super.format() = ${super.format()}")
    }

    constructor() : super() {
        Log.d(OOP_TAG, "EBook 생성자 호출")
    }
}

fun oopExample() {
    val member = Member()
    member.name = "홍길동"
    member.age = 20
    member.gender = 'M'
    member.printMemberInfo()

    Book("B0001", "코틀린 입문")
    Author("홍길순", 3)
    Author("임꺽정")

    val info1 = BookInfo("코틀린 입문", 20000)
    val info2 = BookInfo("코틀린 입문", 20000)
    Log.d(OOP_TAG, "data class toString : $info1")
    Log.d(OOP_TAG, "data class equals : ${info1 == info2}")
    Log.d(OOP_TAG, "data class copy : ${info1.copy(price = 18000)}")

    Log.d(OOP_TAG, "Product: ${Product().describe()}")
    Log.d(OOP_TAG, "PaperBook: ${PaperBook().describe()}")

    val ordered = OrderedBook()
    Log.d(OOP_TAG, "OrderedBook: ${ordered.deliver()}")
    Log.d(OOP_TAG, "OrderedBook: ${ordered.track()}")

    Log.d(OOP_TAG, "CardPayment: ${CardPayment().pay()}")

    val ebook = EBook()
    ebook.printNames()
    ebook.callFormatMethods()
}

fun nullExample() {
    val title: String = "코틀린 입문"
    Log.d("코틀린 : 널 처리", "Non-nullable : $title")

    var coupon: String? = null
    Log.d("코틀린 : 널 처리", "Nullable : $coupon")

    Log.d("코틀린 : 널 처리", "coupon?.length = ${coupon?.length}")

    val couponLen = coupon?.length ?: 0
    Log.d("코틀린 : 널 처리", "coupon?.length ?: 0 = $couponLen")

    coupon = "WELCOME10"
    Log.d("코틀린 : 널 처리", "coupon!!.length = ${coupon!!.length}")

    val memo: String? = null
    memo?.let { Log.d("코틀린 : 널 처리", "메모 : $it") }
    coupon?.let { Log.d("코틀린 : 널 처리", "쿠폰 코드 : $it") }
}

class CartItem {
    var title: String = ""
    var price: Int = 0
    var qty: Int = 1
}

fun scopeFunctionExample() {
    val searchKeyword: String? = "코틀린"
    val resultMsg = searchKeyword?.let { "'$it' 검색 결과 ${it.length}글자" }
    Log.d("코틀린 : 스코프 함수 let", "$resultMsg")

    val item = CartItem()
    item.title = "코틀린 입문"
    item.price = 20000
    item.qty = 2
    val total = item.run { price * qty }
    Log.d("코틀린 : 스코프 함수 run", "합계 : $total")

    val summary = with(item) {
        "$title / ${price}원 x ${qty}권"
    }
    Log.d("코틀린 : 스코프 함수 with", summary)

    val item2 = CartItem().apply {
        title = "안드로이드 프로그래밍"
        price = 30000
        qty = 1
    }
    Log.d("코틀린 : 스코프 함수 apply", "${item2.title} ${item2.price}원")

    val cart = mutableListOf("코틀린 입문")
        .also { Log.d("코틀린 : 스코프 함수 also", "장바구니 생성 : $it") }
        .also { it.add("자바 입문") }
    Log.d("코틀린 : 스코프 함수 also", "최종 장바구니 : $cart")
}
