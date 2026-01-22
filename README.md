Integer Digits Counter
======================

Counts the number of digits in the integer part of a number.
Negative numbers and all number lengths are supported. 

# Run
Run the application for specific number using mill:

```sh
scala-cli . -- -1234.56
```

This will print 4.

## Tests
Run the tests using:
```sh
scala-cli test .
```

## Implementation
Relies on BigDecimal to handle all numeric strings from the console. 

digileo.demo.DigitisCounter.countDigits handles java.lang.Number instances. 

Implemented with Scala 3, Mill, and MUnit

## Author
Mario Lyon <mario@digileo.com>
