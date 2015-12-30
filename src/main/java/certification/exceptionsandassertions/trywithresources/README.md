Remember that only a try-with-resources statement is permitted to omit
both the catch and finally blocks. A traditional try statement must have
either or both.

Closeable interface:
- restricts the type of exception thrown to IOException
- requires implementations to be idempotent

try-with-resources rules:
- Resources are closed after the try clause ends and before any catch/finally clauses. 
- Resources are closed in the reverse order from which they were created.
