import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserAuthService } from 'src/app/services/user-login/user-auth.service';
import { UserRegistrationService } from 'src/app/services/user-registration/user-registration.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {
  
  myFormGroup : FormGroup;
  emailValid : boolean = false;
  prePasswordCheck : boolean = false;
  passwordValidation :boolean = false;
  passwordLength : boolean = false;
  showElement : boolean = false;

  constructor(public router : Router , formBuilder : FormBuilder, public forgotService : UserAuthService) {
    this.myFormGroup=formBuilder.group({
      "email" : new FormControl("",[Validators.required]),
      "password" : new FormControl("", [Validators.required]),
      "rePassword" : new FormControl("", [Validators.required])
    })
   }

   emailValidation(email : HTMLInputElement){
    if (/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(email.value))
    {
      this.emailValid = false;
      // console.log(this.emailValid)
    }
    else{
  
      this.emailValid = true;
      // console.log(this.emailValid)
    }
    if(email.value.length==0){
      this.emailValid = false
    }
  }  

   //check if password and repassword are same

   checkPassword(password : HTMLInputElement,rePassword : HTMLInputElement){
    
    // console.log(password.value,rePassword.value);
    if(password.value.length!=0){
        this.prePasswordCheck = false;
          if(password.value == rePassword.value || rePassword.value.length==0){
              this.passwordValidation = false;
            }else{
                this.passwordValidation = true;
            }
          }else{
                this.prePasswordCheck = true;
    }
  if(rePassword.value.length==0){
    this.prePasswordCheck = false;
  }
  if(this.prePasswordCheck){
    rePassword.value="";
  }
  }

  // Check prePassword
  checkPrePassword(password : HTMLInputElement ){
    if(password.value.length>=6 && password.value.length<=12){
      this.passwordLength = false;
      }
      else{
        this.passwordLength = true;
      }
    if(password.value.length!=0){
      this.prePasswordCheck = false;
    }else{
      this.passwordLength = false;
    }
  } 

  forgot(){
    if(this.emailValid == false && this.passwordValidation == false){
      let username = this.myFormGroup.controls['email'].value;
      let newPassword = this.myFormGroup.controls['password'].value;
     
      this.forgotService.forgotPassword(username,newPassword)
      .subscribe((response)=>{
        console.log(response);
        this.showElement = true;
        setTimeout(function() {
          console.log('hide');
          this.showElement = false;
          this.router.navigate(['/login'])
        }.bind(this), 3000);
        this.myFormGroup.controls['email'].reset()
        this.myFormGroup.controls['password'].reset()
        this.myFormGroup.controls['rePassword'].reset()   
      },
      // failure function
      failureData => {
        console.log(failureData);
      })}else{
        alert("error occured!!")
      }
    }


  ngOnInit(): void {
  }

}
