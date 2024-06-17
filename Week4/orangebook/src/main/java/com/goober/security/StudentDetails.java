// package com.goober.security;

// import java.util.Arrays;
// import java.util.Collection;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

// import com.goober.model.Student;

// public class StudentDetails implements UserDetails {

// private Student student;

// public StudentDetails(Student student) {
//     this.student = student;
// }

//  @Override
//     public Collection<? extends GrantedAuthority> getAuthorities() {
//         SimpleGrantedAuthority authority = new SimpleGrantedAuthority(student.getRole());
//         return Arrays.asList(authority);
//     }
 
//     @Override
//     public String getPassword() {
//         return student.getPassword();
//     }
 
//     @Override
//     public String getUsername() {
//         return student.getUserName();
//     }
 
//     @Override
//     public boolean isAccountNonExpired() {
//         return true;
//     }
 
//     @Override
//     public boolean isAccountNonLocked() {
//         return true;
//     }
 
//     @Override
//     public boolean isCredentialsNonExpired() {
//         return true;
//     }
 
//     @Override
//     public boolean isEnabled() {
//         return true;
//     }
    
// }
