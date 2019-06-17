# JSON Parser

This is a very simple JSON Parser. It parses JSONs of the form:

```
{
  "root": [
    {
      "child-2-0": [
        {
          "child-1-0": []
        },
        {
          "child-1-1": []
        },
        {
          "child-1-2": []
        }
      ]
    },
    {
      "child-2-1": [
        {
          "child-1-0": []
        },
        {
          "child-1-1": []
        },
        {
          "child-1-2": []
        }
      ]
    },
    {
      "child-2-2": [
        {
          "child-1-0": []
        },
        {
          "child-1-1": []
        },
        {
          "child-1-2": []
        }
      ]
    }
  ]
}
```

The parser is generic enough to handle tree of any height or number of children as long as it follows the given structure.

**NOTE**: The parser can handle any keys (i.e. it need not be of the form mentioned here)

Main method has been provided to generate random tree structures (different height and number of children for each run) and to test if the parsing happens correctly. The main method follows the following logic:

* generate a tree, 
* convert it to a JSON string, 
* send the string to the parser, 
* receive the parsed Node structure, 
* convert that back to string 
* compare this string with the original string provided to the parser (step 3)

