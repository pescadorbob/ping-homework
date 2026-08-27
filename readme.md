# Homework

This page represents my notes while going through the programming exercise.

## Filter

```
filter
filter.matches(user)

filter.withExpression(
    anOperand("name"),
    anOperator(isEqual),
    anOperand("Brent")
)
```

---

## Predicate

```
predicate? = parameters and returns false.
```

So, I think of expressions as the "filter predicate".

---

## User Example

```
User
{
    name: Brent
    age: 53
    US Citizen: "true"
}

user
name:
```

---

## Boolean Literal Example

```
e.g. boolean literal -> new BooleanExpression("isAlive", true)
isAlive: true
false
```

---

## Logical Operators

```
logical operators
lhs = expression
operator = new Logical Operator("AND")
rhs = rh Expression
new LogicalExpression(lhs, operator, rhs)
```

---

## Comparison Operator

```
Comparison Operator
present = new isPresentOperator("name")
equal to some value = new Binomial Expression(lhs, operator, rhs)
lhs = new PropertyExpression("first name")
operator = new RelationshipOperator(EQUAL_TO)
rhs = new Value Expression("Joe")
```

So then, let's right our first test that just tries the boolean filter.

```Java
@Test
    void evaluateToTrue_givenUserWithNameAndPredicateWithIsPresent() {
        var user = aResource().withProperty("name", "John").build();
        var isPresentExpression = new IsPresentExpression("name");
        var filter = new FilterPredicate(isPresentExpression);
        var expected = true;

        var actual = filter.matches(user);

        assertThat(actual).isEqualTo(expected);
    }
```

Implement the simplest thing

### Later...

I took those first ideas, starting writing tests, and implementing item by item. By far the most complex part was registering evaluators to expressions, and then to get arbitrarily complex filter, the binomial expression was needed. After that, I think you can see how to extend this further and further.

# String Representation.

Let's say that we wanted a filter in a string, so we could parse the string, and build that filter.

Consider the simple filter ["name" == "John"] that could easily be tokenize to a comparison filter with a parser.

```
"name" == "John" AND "age" == "35 AND "weight" < "250"
```

could also be parsable.

Arbitrarily complex filters, with say nested expressions could be fun as well, and could work with this.

```Shell
("name" == "John" AND "age" == "35") OR "weight" < "250"
```

The parenthesis would indicate a new expression. You could recursively parse out the tokens, and recurse when parenthesis are found.

# Extensibility

To extend the API to extend it to include support for new types of filter, I believe now that you see that you could register an evaluator for each type of expression, then the pattern for supporting new types of filters would be pretty straight forward.

Add a new type of expression, create an evaluator, register the evaluator. If you create a parser, register the token that represents it, etc.

To support 3rd party applications which need to perform some logic based on the structure and content of a filter in a **type-safe** manner then you could imagine a resource with instead of `"age":"23"`, something like `"age":23`.

To represent that better then, you could extend the ComparisonExpression to NumericComparisonExpression e.g. Your parser would have to change a bit, like maybe 


```Shell
("name" == "John" AND "age" == 35) OR "weight" < 250
```

You could even let them register their own token parser, expression types and evaluators that could be configured either through introspection of the code, or a json configuration, e.g.

E.g. a service that wants to filter collections of arbitrary resources could construct the filter using the APIs, (I'd recommend creating a builder though to make it easier to use), and then iterate through the array calling `filter.matches` on each item.

# Future

I didn't like the if `instanceof` conditionals that I had in there, and would figure out the generics for that. I have to often go back and relearn generics, or explore the visitor pattern.

Thanks for reading, this was fun.
