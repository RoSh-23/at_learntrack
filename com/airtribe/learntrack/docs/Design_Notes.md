# Design Notes

## Used Thread Safe way to generate Ids
    Used AtomicLong to store Id counter variables this ensures that when multiple threads try to create new objects the counter value remains consistent and does not get corrupt.
## Created Repository as an interface
    Created a Repository interface which asks for implementing classes to implement methods like add(), listAll(), searchById() etc. this allows for creating various implementations for different entitities and different types of repositories easily with a decided contract, like InMemoryRepository, FileBaseRepository, DatabaseRepository etc.

## Used Static members
    Used Static members to generateIds and for utlities like input validator methids, sicne they are not required to be part of and instansiated object of a class, and are utilities to be shared across the system.

## Used ArrayList instead of Array
    Array's are fixed in size, therefore used ArrayList to ensure that dynamically growth/shrinkage of the List can take place based on the need, it leads to more optmial utlilization of memory.