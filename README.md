dbidmaker
=========

DbIdMaker generates pseudo unique 63 bits ids. It can be used for generating database ids for entities as replace of auto increment keys. It useful in distributed environment, where it is hard to handle numeric sequence. Inspired by MongoDB ObjectID format and Twitter snowflake service.


*63 bit Id consist of*:

1. *timestemp* in milliseconds, **41 bits**
2. *machine id*, **10 bits** (by default: a part of last octects of machine mac address)
3. *sequence*, **12bits** (sequence number by modulo 2^12, allows given machine per each millisecond of time to have 4096 unique ids)
