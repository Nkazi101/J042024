// package com.goober.security;
 
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;

// import com.goober.model.Student;
// import com.goober.repository.StudentRepository;
 
// public class StudentDetailsServiceImpl implements UserDetailsService {
 
//     @Autowired
//     private StudentRepository studentRepository;
     
//     @Override
//     public StudentDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//         Student student = studentRepository.findByEmail(email);
         
//         if (student == null) {
//             throw new UsernameNotFoundException("Could not find user");
//         }
         
//         return new StudentDetails(student);
//     }
 
// }