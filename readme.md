
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
