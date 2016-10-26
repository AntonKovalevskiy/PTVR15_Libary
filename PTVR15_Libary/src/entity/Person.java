package entity;

import java.util.Objects; 
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType; 
import javax.persistence.Id; 
import javax.persistence.Transient; 
import util.ParseCode; 

@Entity 
public class Person { 

@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY) 

private Long id; 

private String fistname; 

private String lastname; 

private String code; 

@Transient 

private ParseCode parseCode; 

public Person() { 
} 

public Person(String fistname, String lastname, String code) { 
this.parseCode = new ParseCode(code); 
this.fistname = fistname; 
this.lastname = lastname; 
this.code = code; 
} 



public String getFistname() { 
return fistname; 
} 

public void setFistname(String fistname) { 
this.fistname = fistname; 
} 

public String getLastname() { 
return lastname; 
} 

public void setLastname(String lastname) { 
this.lastname = lastname; 
} 

public String getCode() { 
return code; 
} 

public void setCode(String code) { 
this.code = code; 
} 

@Override 
public int hashCode() { 
int hash = 3; 
hash = 67 * hash + Objects.hashCode(this.fistname); 
return hash; 
} 

@Override 
public boolean equals(Object obj) { 
if (obj == null) { 
return false; 
} 
if (getClass() != obj.getClass()) { 
return false; 
} 
final Person other = (Person) obj; 
if (!Objects.equals(this.fistname, other.fistname)) { 
return false; 
} 
return true; 
} 

@Override 
public String toString() { 
return "\nPerson{" + "\n fistname: " + fistname 
+ "\n lastname: " + lastname 
+ "\n code: " + code 
+ "\n parseCode: " + parseCode + '}'; 
} 

public Long getId() { 
return id; 
} 

public void setId(Long id) { 
this.id = id; 
} 

}
