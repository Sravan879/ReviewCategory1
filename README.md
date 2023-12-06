In this project, we will develop a Spring Boot application to provide a REST service for the 'NxtTrendz' application. With 'NxtTrendz', users can effortlessly explore various products within distinct categories.

For this application, the primary entities to be represented are `Product` and `Category`. The `Product` entity establishes a Many-to-One relationship with the `Category` entity.

<details>
<summary>**Implementation Files**</summary>

Use these files to complete the implementation:

- `ProductController.java`
- `ProductRepository.java`
- `ProductJpaService.java`
- `ProductJpaRepository.java`
- `Product.java`
- `CategoryController.java`
- `CategoryRepository.java`
- `CategoryJpaService.java`
- `CategoryJpaRepository.java`
- `Category.java`

</details>

Create a database that contains two tables `category` and `product` using the given database schema.

You can refer to this [session](https://learning.ccbp.in/course?c_id=e345dfa4-f5ce-406e-b19a-4ed720c54136&s_id=6a60610e-79c2-4e15-b675-45ddbd9bbe82&t_id=f880166e-2f51-4403-81a0-d2430694dae8), for creating a database.

_Create the SQL files and compose accurate queries to run the application. Inaccurate SQL files will result in test case failures._

<details>
<summary>**Database Schema**</summary>

#### Product Table

|   Columns   |                 Type                  |
| :---------: | :-----------------------------------: |
|     id      | INTEGER (Primary Key, Auto Increment) |
|    name     |                 TEXT                  |
| description |                 TEXT                  |
|    price    |                DOUBLE                 |
| categoryId  |                INTEGER                |

#### Category Table

|   Columns   |                 Type                  |
| :---------: | :-----------------------------------: |
|     id      | INTEGER (Primary Key, Auto Increment) |
|    name     |                 TEXT                  |
| description |          TEXT (Foreign Key)           |

You can use the given sample data to populate the tables.

<details>
<summary>**Sample Data**</summary>

#### Category Data

|  id   |    name     |                   description                   |
| :---: | :---------: | :---------------------------------------------: |
|   1   | Electronics |      Gadgets and devices for everyday use.      |
|   2   |    Books    | Novels, textbooks, and other reading materials. |
|   3   |   Fashion   |      Clothing, footwear, and accessories.       |

#### Product Data

|       name        |                              description                              |  price   | categoryId |
| :---------------: | :-------------------------------------------------------------------: | :------: | :--------: |
|      Laptop       | A high-performance laptop suitable for gaming and professional tasks. | 50000.00 |     1      |
| Bluetooth Speaker |           A portable speaker with excellent sound quality.            | 2500.00  |     1      |
|   Mystery Novel   |              A thrilling novel full of twists and turns.              |  500.00  |     2      |
| History Textbook  |                A comprehensive guide to world history.                |  400.00  |     2      |
|  Leather Jacket   |               A stylish jacket made of genuine leather.               | 2200.00  |     3      |
|   Running Shoes   |                Comfortable shoes perfect for jogging.                 |  700.00  |     3      |

</details>

</details>

<MultiLineNote>

Use only `product` and `category` as the table names in your code.

</MultiLineNote>

### Completion Instructions

- `Product.java`: The `Product` class should contain the following attributes.

    |  Attribute  |   Type   |
    | :---------: | :------: |
    |     id      |   int    |
    |    name     |  String  |
    | description |  String  |
    |    price    |  double  |
    |  category   | Category |

- `ProductRepository.java`: Create an `interface` containing the required methods.
- `ProductJpaService.java`: Update the service class with logic for managing product data.
- `ProductController.java`: Create the controller class to handle HTTP requests.
- `ProductJpaRepository.java`: Create an interface that implements the `JpaRepository` interface.
  
- `Category.java`: The `Category` class should contain the following attributes.

    |  Attribute  |  Type  |
    | :---------: | :----: |
    |     id      |  int   |
    |    name     | String |
    | description | String |

- `CategoryRepository.java`: Create an `interface` containing the required methods.
- `CategoryJpaService.java`: Update the service class with logic for managing categories data.
- `CategoryController.java`: Create the controller class to handle HTTP requests.
- `CategoryJpaRepository.java`: Create an interface that implements the `JpaRepository` interface.

Implement the following APIs.

<details>
<summary>**API 1: GET /categories**</summary>

#### Path: `/categories`

#### Method: `GET`

#### Description:

Returns a list of all categories in the `category` table.

#### Response

```json
[
    {
        "id": 1,
        "name": "Electronics",
        "description": "Gadgets and devices for everyday use."
    },
    ...
]
```

</details>

<details>
<summary>**API 2: POST /categories**</summary>

#### Path: `/categories`

#### Method: `POST`

#### Description:

Creates a new category in the `category` table. The `categoryId` is auto-incremented.

#### Request

```json
{
    "name": "Home Appliances",
    "description": "Essential tools for household tasks."
}
```

#### Response

```json
{
    "id": 4,
    "name": "Home Appliances",
    "description": "Essential tools for household tasks."
}
```

</details>

<details>
<summary>**API 3: GET /categories/{categoryId}**</summary>

#### Path: `/categories/{categoryId}`

#### Method: `GET`

#### Description:

Returns a category based on the `categoryId`. If the given `categoryId` is not found in the `category` table, raise `ResponseStatusException` with `HttpStatus.NOT_FOUND`.


#### Success Response

```json
{
    "id": 2,
    "name": "Books",
    "description": "Novels, textbooks, and other reading materials."
}
```

</details>

<details>
<summary>**API 4: PUT /categories/{categoryId}**</summary>

#### Path: `/categories/{categoryId}`

#### Method: `PUT`

#### Description:

Updates the details of a category based on the `categoryId` and returns the updated category details. If the given `categoryId` is not found in the `category` table, raise `ResponseStatusException` with `HttpStatus.NOT_FOUND`.

#### Request

```json
{
    "name": "Toys",
    "description": "Fun items for kids and adults alike."
}
```

#### Success Response

```json
{
    "id": 2,
    "name": "Toys",
    "description": "Fun items for kids and adults alike."
}
```

</details>

<details>
<summary>**API 5: DELETE /categories/{categoryId}**</summary>

#### Path: `/categories/{categoryId}`

#### Method: `DELETE`

#### Description:

Deletes a category from the `category` table based on the `categoryId` and returns the status code `204`(raise `ResponseStatusException` with `HttpStatus.NO_CONTENT`). If the given `categoryId` is not found in the `category` table, raise `ResponseStatusException` with `HttpStatus.NOT_FOUND`. 

</details>

<details>
<summary>**API 6: GET /categories/products**</summary>

#### Path: `/categories/products`

#### Method: `GET`

#### Description:

Returns a list of all products in the `product` table.

#### Response

```json
[
    {
        "id": 1,
        "name": "Laptop",
        "description": "A high-performance laptop suitable for gaming and professional tasks.",
        "price": 50000.0,
        "category": {
            "id": 1,
            "name": "Electronics",
            "description": "Gadgets and devices for everyday use."
        }
    },
    ...
]
```

</details>

<details>
<summary>**API 7: POST /categories/products**</summary>

#### Path: `/categories/products`

#### Method: `POST`

#### Description:

Creates a new product in the `product` table and create an association between the product and the category based on the `id` of the `category` field. The `productId` is auto-incremented.

#### Request

```json
{
    "name": "Blender",
    "description": "An efficient kitchen tool for making smoothies.",
    "price": 600.00,
    "category": {
        "id": 4
    }
}
```

#### Response

```json
{
    "id": 7,
    "name": "Blender",
    "description": "An efficient kitchen tool for making smoothies.",
    "price": 600.0,
    "category": {
        "id": 4,
        "name": "Home Appliances",
        "description": "Essential tools for household tasks."
    }
}
```

</details>

<details>
<summary>**API 8: GET /categories/products/{productId}**</summary>

#### Path: `/categories/products/{productId}`

#### Method: `GET`

#### Description:

Returns a product based on the `productId`. If the given `productId` is not found in the `product` table, raise `ResponseStatusException` with `HttpStatus.NOT_FOUND`.


#### Success Response

```json
{
    "id": 2,
    "name": "Bluetooth Speaker",
    "description": "A portable speaker with excellent sound quality.",
    "price": 2500.0,
    "category": {
        "id": 1,
        "name": "Electronics",
        "description": "Gadgets and devices for everyday use."
    }
}
```

</details>

<details>
<summary>**API 9: PUT /categories/products/{productId}**</summary>

#### Path: `/categories/products/{productId}`

#### Method: `PUT`

#### Description:

Updates the details of a product based on the `productId` and returns the updated product details. If the `id` in the `category` field is provided, update the association between the product and the category based on the `id`. If the given `productId` is not found in the `product` table, raise `ResponseStatusException` with `HttpStatus.NOT_FOUND`.

#### Request

```json
{
    "name": "Lego Set",
    "description": "A 500-piece Lego set for building and creativity.",
    "price": 300.00,
    "category": {
        "id": 2
    }
}
```

#### Success Response

```json
{
    "id": 4,
    "name": "Lego Set",
    "description": "A 500-piece Lego set for building and creativity.",
    "price": 300.0,
    "category": {
        "id": 2,
        "name": "Toys",
        "description": "Fun items for kids and adults alike."
    }
}
```

</details>

<details>
<summary>**API 10: DELETE /categories/products/{productId}**</summary>

#### Path: `/categories/products/{productId}`

#### Method: `DELETE`

#### Description:

Deletes a product from the `product` table based on the `productId` and returns the status code `204`(raise `ResponseStatusException` with `HttpStatus.NO_CONTENT`). If the given `productId` is not found in the `product` table, raise `ResponseStatusException` with `HttpStatus.NOT_FOUND`.

</details>

<details>
<summary>**API 11: GET /products/{productId}/category**</summary>

#### Path: `/products/{productId}/category`

#### Method: `GET`

#### Description:

Returns a category of the product based on the `productId`. If the given `productId` is not found in the `product` table, raise `ResponseStatusException` with `HttpStatus.NOT_FOUND`.

#### Response

```json
{
    "id": 1,
    "name": "Electronics",
    "description": "Gadgets and devices for everyday use."
}
```

</details>

**Do not modify the code in `NxtTrendzApplication.java`**