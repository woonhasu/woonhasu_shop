# woonhasu_shop
![home (1)](https://user-images.githubusercontent.com/68639271/132803640-28fb487e-f4cf-4742-87a4-93db237fdb68.gif)
## π μ΄νμ μΌν

μ΄νμ μΌνμ `νμ`,`μ ν`,`μ₯λ°κ΅¬λ`,`μ£Όλ¬Έλ΄μ­` CRUDλ₯Ό κ΅¬νν μ¨λΌμΈ μΌν μλΉμ€ μλλ€. 

- νμκ°μ
- νμμ λ³΄μμ 
- νμνν΄
- λ‘κ·ΈμΈ(μ μ /κ΄λ¦¬μ)
- λ‘κ·Έμμ
- μνμΉ΄νΈμ μ₯/μ­μ 
- μνμ λ³΄μΆκ°/μμ /μ­μ 
- λ¨μΌμνμ£Όλ¬Έ/μ­μ 
- μ μ²΄μνμ£Όλ¬Έ
- νμμ λ³΄νμΈ


## π¨βπ§βπ§ **Team**
### [λ°°μ§μ](https://github.com/geesuee)

### [μ‘°νμ΄](https://github.com/henrynoowah)

### [κΉνλ](https://github.com/aNnaHmiK)

[woonhasu](https://github.com/woonhasu)


## β κ°λ° νκ²½
- `Java` : 1.8 version
- `Eclipse` : photon
- `OracleDB`
- `Maven`
- `Tomcat`
- `JPA` / `Lombok`
- `Servlet` / `JSP`
- `HTML` / `CSS` / `JavaScript`


# 2. SQL
- DDL

    ```sql
    DROP TABLE orders;
    DROP TABLE cart;
    DROP TABLE product;
    DROP TABLE users;

    DROP SEQUENCE orders_SEQ;
    DROP SEQUENCE cart_SEQ;
    DROP SEQUENCE product_SEQ;
    DROP SEQUENCE users_SEQ;

    CREATE SEQUENCE orders_SEQ
    START WITH 1
    INCREMENT BY 1;

    CREATE SEQUENCE users_SEQ
    START WITH 1
    INCREMENT BY 1;

    CREATE SEQUENCE cart_SEQ
    START WITH 1
    INCREMENT BY 1;

    CREATE SEQUENCE product_SEQ
    START WITH 1
    INCREMENT BY 1;

    CREATE TABLE product
    (
        product_idx     NUMBER           PRIMARY KEY,
        category		VARCHAR2(20)	 NOT NULL,
        product_name    VARCHAR2(50)     NOT NULL, 
        price           NUMBER           NOT NULL, 
        color           VARCHAR2(20)     NULL, 
        psize           VARCHAR2(20)     NULL
    );

    CREATE TABLE cart
    (
        cart_idx       NUMBER          PRIMARY KEY, 
        user_id        VARCHAR2(20)    NOT NULL, 
        product_idx    NUMBER          NULL
    );

    CREATE TABLE orders
    (
        order_idx      NUMBER          PRIMARY KEY,
        user_id        VARCHAR2(20)    NOT NULL, 
        product_idx    NUMBER          NOT NULL, 
        order_date     DATE            NOT NULL
    );

    CREATE TABLE users
    (
        id         VARCHAR2(20)     PRIMARY KEY,
        pw         VARCHAR2(20)     NOT NULL, 
        admin	     NUMBER(1)		NOT NULL,
        name       VARCHAR2(20)     NOT NULL, 
        address    VARCHAR2(300)    NOT NULL, 
        phone      VARCHAR2(20)     NOT NULL 
    );

    ALTER TABLE orders  ADD FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE;
    ALTER TABLE orders  ADD FOREIGN KEY (product_idx) REFERENCES product(product_idx) ON DELETE CASCADE;
    ALTER TABLE cart  ADD FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE;
    ALTER TABLE cart  ADD FOREIGN KEY (product_idx) REFERENCES product(product_idx) ON DELETE CASCADE;
    ```

- DML

    ```sql
    INSERT INTO product VALUES(product_SEQ.NEXTVAL, 'bottom', 'μ½νΌν¬μΈ ', 40000, 'beige', 'free');
    INSERT INTO product VALUES(product_SEQ.NEXTVAL, 'setup', 'μ¬λΈλ μμ', 68000, 'black', 'free');
    INSERT INTO product VALUES(product_SEQ.NEXTVAL, 'top', 'μ€νΈλΌμ΄ν μμΈ ', 34000, 'blue', 'free');
    INSERT INTO product VALUES(product_SEQ.NEXTVAL, 'outer', 'μμΉ΄λΌ μ½νΈ', 48000, 'blue', 'free');
    INSERT INTO product VALUES(product_SEQ.NEXTVAL, 'top', 'νλ μλΈλ½', 36000, 'khaki', 'free');
    INSERT INTO product VALUES(product_SEQ.NEXTVAL, 'top', 'κ·Έλ μ΄ νλν°', 30000, 'grey', 'free');
    INSERT INTO product VALUES(product_SEQ.NEXTVAL, 'bottom', 'λ² μ΄μ§ μ½νΌ μ€μ»€νΈ', 32000, 'beige', 'free');

    INSERT INTO users VALUES('admin', 'adminpw', '1', 'κ΄λ¦¬μ', 'κ΄λ¦¬μμ§', '01012345678');
    INSERT INTO users VALUES('geesuee', 'jisu', '0', 'λ°°μ§μ', 'μΈμ² μ€κ΅¬ νλλ³λΉλ‘ 121', '01030576577');
    INSERT INTO users VALUES('noowah', 'noowah', '0', 'μ‘°νμ΄', 'μμΈ μνκ΅¬ λΆκ΄λ‘ 16κΈΈ 25-7 2μΈ΅', '01044460410');
    INSERT INTO users VALUES('paparo2', 'papa', '0', 'κΉνλ', 'κ²½κΈ°λ μΌνλ λνκ΅λ‘ 212', '01066000028');

    INSERT INTO cart VALUES(cart_SEQ.NEXTVAL, 'noowah', 1);
    INSERT INTO orders VALUES(orders_SEQ.NEXTVAL, 'noowah', 1, '2021-09-06');

    commit;
    ```

# 3. Directory Tree

- project λλ ν λ¦¬ νΈλ¦¬

    ```html
    C:.
    β  .classpath
    β  .gitignore
    β  .project
    β  pom.xml
    β
    ββ.settings
    β      .jsdtscope
    β      org.eclipse.jdt.core.prefs
    β      org.eclipse.jpt.core.prefs
    β      org.eclipse.m2e.core.prefs
    β      org.eclipse.wst.common.component
    β      org.eclipse.wst.common.project.facet.core.prefs.xml
    β      org.eclipse.wst.common.project.facet.core.xml
    β      org.eclipse.wst.jsdt.ui.superType.container
    β      org.eclipse.wst.jsdt.ui.superType.name
    β      org.eclipse.wst.validation.prefs
    β
    ββbuild
    β  ββclasses
    β      ββMETA-INF
    β              persistence.xml
    β
    ββsql
    β      ddl.sql
    β      dml.sql
    β
    ββsrc
    β  ββcontroller
    β  β      Controller.java
    β  β
    β  ββexception
    β  β      MessageException.java
    β  β      NotExistException.java
    β  β
    β  ββMETA-INF
    β  β      persistence.xml
    β  β
    β  ββmodel
    β  β  ββDAO
    β  β  β      CartDAO.java
    β  β  β      OrdersDAO.java
    β  β  β      ProductDAO.java
    β  β  β      Service.java
    β  β  β      UsersDAO.java
    β  β  β
    β  β  ββdomain
    β  β  β      Cart.java
    β  β  β      Orders.java
    β  β  β      Product.java
    β  β  β      Users.java
    β  β  β
    β  β  ββDTO
    β  β          CartDTO.java
    β  β          OrdersDTO.java
    β  β          ProductDTO.java
    β  β          UsersDTO.java
    β  β
    β  ββutil
    β          DBUtil.java
    β
    ββtarget
    β  ββclasses
    β  β  ββcontroller
    β  β  β      Controller.class
    β  β  β
    β  β  ββexception
    β  β  β      MessageException.class
    β  β  β      NotExistException.class
    β  β  β
    β  β  ββMETA-INF
    β  β  β      persistence.xml
    β  β  β
    β  β  ββmodel
    β  β  β  ββDAO
    β  β  β  β      CartDAO.class
    β  β  β  β      OrdersDAO.class
    β  β  β  β      ProductDAO.class
    β  β  β  β      Service.class
    β  β  β  β      UsersDAO.class
    β  β  β  β
    β  β  β  ββdomain
    β  β  β  β      Cart.class
    β  β  β  β      Orders.class
    β  β  β  β      Product$ProductBuilder.class
    β  β  β  β      Product.class
    β  β  β  β      Users$UsersBuilder.class
    β  β  β  β      Users.class
    β  β  β  β
    β  β  β  ββDTO
    β  β  β          CartDTO$Get.class
    β  β  β          CartDTO.class
    β  β  β          OrdersDTO$Create.class
    β  β  β          OrdersDTO$Get.class
    β  β  β          OrdersDTO.class
    β  β  β          ProductDTO$Create.class
    β  β  β          ProductDTO$Get.class
    β  β  β          ProductDTO$Update.class
    β  β  β          ProductDTO.class
    β  β  β          UsersDTO$Cart.class
    β  β  β          UsersDTO$Create.class
    β  β  β          UsersDTO$Delete.class
    β  β  β          UsersDTO$Get.class
    β  β  β          UsersDTO$LogIn.class
    β  β  β          UsersDTO$Order.class
    β  β  β          UsersDTO$Update.class
    β  β  β          UsersDTO.class
    β  β  β
    β  β  ββutil
    β  β          DBUtil.class
    β  β
    β  ββm2e-wtp
    β  β  ββweb-resources
    β  β      ββMETA-INF
    β  β          β  MANIFEST.MF
    β  β          β
    β  β          ββmaven
    β  β              ββplaydata
    β  β                  ββstep12_webProject
    β  β                          pom.properties
    β  β                          pom.xml
    β  β
    β  ββtest-classes
    ββWebContent
        β  addProduct.jsp
        β  cart.jsp
        β  index.html
        β  login.jsp
        β  manageOrders.jsp
        β  manageProduct.jsp
        β  manageUsers.jsp
        β  myPage.jsp
        β  orders.jsp
        β  productCategory.jsp
        β  productName.jsp
        β  register.jsp
        β  shop.jsp
        β  showError.jsp
        β  updateUser.jsp
        β
        ββcommon
        β      headerNav.jsp
        β      searchBar.jsp
        β
        ββcss
        β      style.css
        β
        ββimages
        β      1.jpg
        β      2.jpg
        β      3.jpg
        β      4.jpg
        β      5.jpg
        β      6.jpg
        β      7.jpg
        β
        ββjs
        β      canvas.js
        β
        ββMETA-INF
        β      MANIFEST.MF
        β
        ββWEB-INF
            β
            ββlib
                    taglibs-standard-impl-1.2.5.jar
                    taglibs-standard-spec-1.2.5.jar
    ```

- java src λλ ν λ¦¬ νΈλ¦¬

    ```html
    C:.
    ββcontroller
    β      Controller.java
    β
    ββexception
    β      MessageException.java
    β      NotExistException.java
    β
    ββMETA-INF
    β      persistence.xml
    β
    ββmodel
    β  ββDAO
    β  β      CartDAO.java
    β  β      OrdersDAO.java
    β  β      ProductDAO.java
    β  β      Service.java
    β  β      UsersDAO.java
    β  β
    β  ββdomain
    β  β      Cart.java
    β  β      Orders.java
    β  β      Product.java
    β  β      Users.java
    β  β
    β  ββDTO
    β          CartDTO.java
    β          OrdersDTO.java
    β          ProductDTO.java
    β          UsersDTO.java
    β
    ββutil
            DBUtil.java
    ```

- WebContent λλ ν λ¦¬ νΈλ¦¬

    ```html
    C:.
    β  addProduct.jsp
    β  cart.jsp
    β  index.html
    β  login.jsp
    β  manageOrders.jsp
    β  manageProduct.jsp
    β  manageUsers.jsp
    β  myPage.jsp
    β  orders.jsp
    β  productCategory.jsp
    β  productName.jsp
    β  register.jsp
    β  shop.jsp
    β  showError.jsp
    β  updateUser.jsp
    β
    ββcommon
    β      headerNav.jsp
    β      searchBar.jsp
    β
    ββcss
    β      style.css
    β
    ββimages
    β      1.jpg
    β      2.jpg
    β      3.jpg
    β      4.jpg
    β      5.jpg
    β      6.jpg
    β      7.jpg
    β
    ββjs
    β      canvas.js
    β
    ββMETA-INF
    β      MANIFEST.MF
    β
    ββWEB-INF
        ββlib
                taglibs-standard-impl-1.2.5.jar
                taglibs-standard-spec-1.2.5.jar
    ```

## π νΈλ¬λΈ μν / μ΄μ
- **JSTL μ‘°κ±΄λ¬Έ**
    - `JSP` λ΄λΆ `<c:if>` νκ·Έ μ¬μ©μ μ‘°κ±΄μ λͺ¨λ EL Tag "${}" λ΄λΆμμλ§ μμ±

    ```html
    μμ
    <c:if test="${product.idx == 1}">    O
    <c:if test="${product.idx} == 1">    X

    <c:if test="${not empty sessionScope.user && sessionScope.user.admin==0}">   O
    <c:if test="${not empty sessionScope.user} && ${sessionScope.user.admin==0}">   X
    ```

- **DELETE ON CASCADE**
    - νμ μ λ³΄ μ­μ  μ λΆλͺ¨μμ κ΄κ³λ‘ mapping λ νμ΄λΈ(orders, cart) λ κ°μ΄ μ­μ λ  μ μκ² `on delete cascade` μ€μ  νμ
    - cascade μ€μ μ Entity, SQLμ€ νλλ§ μ μ©ν΄λ μ¬μ© κ°λ₯

- **1:ε€ λ§€ν κ΄κ³ λ΄ κ°μ²΄ μμ **
    - μμ ν  κ°μ²΄κ° κΈ°λ³Έ νμ μμ±μΈμ§, μ°Έμ‘° νμ μμ±μΈμ§ νμΈ νμ
    - λ§€νλ νμ΄λΈμ DBμ μ°Έμ‘°κ°μ²΄μ PKλ§ κ°μ§κ³  μλκ²μ²λΌ λ³΄μ΄μ§λ§ μ¬μ€μ μ°κ²°λ μ°Έμ‘°κ°μ²΄μ λͺ¨λ  μμ±μ λ³΄μ 
    - λ§€νλ νμ΄λΈμ μ°Έμ‘°νλ μν°ν°μ PKνμ© β μμ  μ PKλ‘ DBλ‘ μ κ·Όνμ¬ λ§€ν κ΄κ³λ₯Ό μ¬μ μ

- `CSS`**,** `JS` **λ± λΈλΌμ°μ  μΈμ΄ λ―Έμ μ©**
    - λΈλΌμ°μ  μΈμ΄κ° μλ°μ΄νΈ μλ  μ λΈλΌμ°μ  "μΊμ λΉμ°κΈ° λ° κ°λ ₯μλ‘κ³ μΉ¨" μ€ν

- **GitHub Auto-merge - ν­μ μμ¬!**
    - μμ  μ  μ½λλΌμΈμΌλ‘ Auto-merge μ£Όμ
    - νμΌλͺ μμ  μ merge λΈλμΉμ base νμΈ
    - Git Bash κ΄λ ¨ λ¬Έμ  λ°μ


## π© μμ¬μ΄ μ  / μΆκ°νκ³  μΆμ μ 
- μ₯λ°κ΅¬λ(cart) λ΄ μ€λ³΅ μ¬ν­μ λν΄μ μλμΌλ‘ νν / μλ μμ  κΈ°λ₯ κ΅¬ν
- μ£Όλ¬Έλ΄μ­ μλ₯Ό κΈ°μ€μΌλ‘ νλ§€ best λ¬Όκ±΄ λ¦¬μ€νΈ μΆλ ₯ κ΅¬ν
- νμ΄μ§ μ΄λ λ°©μμ λ°λΌ νΈλμ μ μ±κ³΅ λ©μΈμ§λ₯Ό μΆλ ₯νμ§ λͺ»ν κ² μμ¬μ β νμ μ°½ κ΅¬ν
- μκ°μ΄ μ΄λ°ν΄μ WebContent λΆλΆ νμΌ κ²½λ‘λ₯Ό μ λ¦¬νμ§ λͺ»ν κ²μ΄ μμ¬μ
