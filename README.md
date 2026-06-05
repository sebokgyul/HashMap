a from-scratch HashMap implementation for fun and to understand what 
`java.util.HashMap` actually does under the hood 

one thing i liked: the `& 0x7FFFFFFF` bitmask to strip the sign bit before the modulo —
cleaner than `Math.abs()`, which actually breaks for `Integer.MIN_VALUE` due to integer overflow anyway
