package com.goober.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goober.model.Teacher;

//The repository is an interface that inherits(extends) from the JPArepository
//the jparepository provides methods for crud operations
//in the angle brackets we specify what model/table/entity we'd the repository to be able to execute CRUD operations

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}

// 1	
// count(): long

// returns the number of entities available.

// 2	
// delete(Employee entity): void

// deletes an entity.

// 3	
// deleteAll():void

// deletes all the entities.

// 4	
// deleteAll(Iterable< extends Employee > entities):void

// deletes the entities passed as argument.

// 5	
// deleteAll(Iterable< extends Integer > ids):void

// deletes the entities identified using their ids passed as argument.

// 6	
// existsById(Integer id):boolean

// checks if an entity exists using its id.

// 7 select * from teacher;
// findAll():Iterable< Employee >

// returns all the entities.

// 8	
// findAllByIds(Iterable< Integer > ids):Iterable< Employee >

// returns all the entities identified using ids passed as argument.

// 9	
// findById(Integer id):Optional< Employee >

// returns an entity identified using id.

// 10	
// save(Employee entity): Employee

// saves an entity and return the updated one.

// 11	
// saveAll(Iterable< Employee> entities): Iterable< Employee>

// saves all entities passed and return the updated entities.