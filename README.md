# Spring Boot GraphQL

Demo project for Spring Boot using GraphQL. Created from this youtube
video [🍃 Introduction to Spring GraphQL with Spring Boot](https://youtu.be/atA2OovQBic)

### Queries

- Find All Wizards

``` graphql
query {
  wizards {
    id,
    name,
    rank,
    books {
      title
    }
  }
}
```

- Find Wizard by id

``` graphql
query {
  wizardById(id: 1) {
    id,
    name,
    rank,
    books {
      title
    }
  }
}
```

### Mutations

- Create a new book

```
mutation {
  addBook(book: {title: "New earth dragon", publisher: "Ranoa Magic Academy", wizardId: 1}){
    id,
    title
  }
}
```

### Notes

- Install [GraphQL plugin](https://plugins.jetbrains.com/plugin/8097-graphql) on IntelliJ
- I can do two queries together
- I use mutation to modify registers, example:
```
type Mutation {
    addBook(book: BookInput): Book
}
```

---
Developed by [jjeanjacques10](https://github.com/jjeanjacques10)