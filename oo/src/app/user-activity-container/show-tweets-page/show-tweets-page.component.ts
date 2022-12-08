import { formatDate, LocationStrategy } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CommentsList } from 'src/app/model/commentsList.model';
import { Tweet } from 'src/app/model/tweet.model';
import { TweetResponse } from 'src/app/model/tweetResponse.model';
import { TweetsService } from 'src/app/services/tweets/tweets.service';


@Component({
  selector: 'app-show-tweets-page',
  templateUrl: './show-tweets-page.component.html',
  styleUrls: ['./show-tweets-page.component.css']
})
export class ShowTweetsPageComponent implements OnInit {
  myFormGroup : FormGroup;
  today= new Date();
  todaysDataTime = '';
  clickedReplyButton : {[key: number] : boolean} ={};
  enableLikeButton : {[key: number] : boolean} ={};
  enablePostButton : boolean = false;
  showElement : boolean = false;
  tweets : TweetResponse[];
  singleTweet : TweetResponse;
  commentList : Array<CommentsList>;
  noTweets : boolean = false;
  obj : Object;
  tweetTex : string;
  tweetEmpty : boolean = false;
  showTweetLength : boolean = false;
  remainingTweetLength : number;
  showTweetRed : boolean = false;
  tweetLengthExceeded : boolean = false;
  showModel : boolean = false;
  deleteTweetPopup : boolean = false;
  likedTweetPopup : boolean = false;
  updateTweetPopup : boolean = false;
  // noComments : {[key: number] : boolean} ={};

  constructor(formBuilder : FormBuilder,  private locationStrategy: LocationStrategy, public tweetService : TweetsService , public router : Router) {
    this.todaysDataTime = formatDate(this.today, 'dd-MM-yyyy', 'en-US', '+0530');
    this.myFormGroup=formBuilder.group({
      "reply" : new FormControl("",Validators.required),
    })

  }

  showTweets(){
    // sessionStorage.getItem('name');
    this.tweetService.getAllTweetsOfUser(sessionStorage.getItem('user')).subscribe(response =>{
    this.tweets = response;
      console.log(this.tweets);
      if(this.tweets.length!=0){
        this.noTweets = false;
      }else{
        this.noTweets = true;
      }
      
    });
  }


  deleteTweet(id : string){
    console.log(id);
    this.tweetService.deleteTweet(id).subscribe(response=>{
      console.log(response);
      this.tweetService.getAllTweetsOfUser(sessionStorage.getItem('user')).subscribe(response =>{
        this.tweets = response;
        this.deleteTweetPopup = true;
        setTimeout(function() {
          console.log('hide');
          this.deleteTweetPopup = false;
        }.bind(this), 3000);
        if(this.tweets.length!=0){
          this.noTweets = false;
        }else{
          this.noTweets = true;
        }
      },
      // failure function
      failureData => {
        console.log(failureData);
      });
    });
  }
  
  editTweet(id : string){
    this.showModel = true;
    this.tweetService.editTweet(id).subscribe((response : TweetResponse)=>{
      this.singleTweet = response;
      this.tweetTex = this.singleTweet.tweetText;
      console.log(response);
    })
    }

    tweetLengthValidationMethod(tweetOfUser : HTMLInputElement){
    
      let tweet = tweetOfUser.value;
      if(tweet.length!=0){
        this.tweetEmpty = false;
        this.showTweetLength = true;
        this.remainingTweetLength = 145 - tweet.length ;
        // console.log(this.remainingTweetLength);
      }
      else{
        this.showTweetLength = false
      }
  
      if(tweet.length>=145 && tweet.length!=0){
        this.showTweetRed = true;
        this.tweetLengthExceeded = true;
        
      }else{
        
        this.tweetLengthExceeded = false;
        this.showTweetRed = false;
      }
    }
  
  
  updateTweet(tweet : HTMLInputElement , id : string){
    console.log(id);
    if(tweet.value.length==0){
      this.tweetEmpty = true
    }
    else{
      this.tweetEmpty = false;
    }
    this.tweetService.updateTweet(id,tweet.value).subscribe((response)=>{
      console.log(response);
      if(response == "success"){
        setTimeout(function() {
          this.updateTweetPopup = true;
          console.log(this.updateTweetPopup);
          console.log('hide');
          this.updateTweetPopup = false;
        }.bind(this), 3000);
        this.showModel = false;
        this.showTweets();
        this.closeUpdateTweet(tweet);
      }
    },
    // failure function
    failureData => {
      console.log(failureData);
    });
  }

  closeUpdateTweet(tweet : HTMLInputElement){
    tweet.value='';
    this.showModel = false;
    this.showTweetLength = false;
  }

  likeTweet(id : string){
    console.log(id);
    this.tweetService.likeTweet(id).subscribe((response)=>{
      console.log(response);
      if(response == "success"){
        this.showTweets();
        this.likedTweetPopup = true;
        setTimeout(function() {
          console.log('hide');
          this.likedTweetPopup = false;
        }.bind(this), 3000);
      }
    },
    // failure function
    failureData => {
      console.log(failureData);
    });
  }

  modelshow(){
    console.log("model show called")
    if(this.showModel = false){
      this.showModel =  true
    }else{
      this.showModel = false
    }
    
  }


 
  replyTweet(id : string){
    let reply = this.myFormGroup.controls['reply'].value;
    if(reply.length==0){
      alert("Reply can't be empty");
    }
    else{
        // alert("commented!");
        console.log(id)
        this.tweetService.replyTweet(reply,id).subscribe((response=>{
          console.log(response);
          if(response=="success"){
            this.myFormGroup.controls['reply'].reset();
            this.showElement = true;
            this.showTweets();
            setTimeout(function() {
              console.log('hide');
              this.showElement = false;
            }.bind(this), 3000);
          }
          
        }),
        // failure function
        failureData => {
          console.log(failureData);
        });
        
      }
    }


  showButton(){
    let reply = this.myFormGroup.controls['reply'].value;
    // console.log(reply);
    if(reply.length==0){
      this.enablePostButton = false;
    }else{
      this.enablePostButton = true;
    }
  }

  preventBackButton() {
    // console.log("preventBackButton method")
    history.pushState(null, null, location.href);
    this.locationStrategy.onPopState(() => {
      history.pushState(null, null, location.href);
    })
  }

  openSite(siteUrl) {
    window.open("//" + siteUrl, '_blank');
  }

  isReplyClicked(index : number){
    if(this.clickedReplyButton[index]==false){
    this.clickedReplyButton[index] = true;
  }
    else
    this.clickedReplyButton[index] = false;
  }


  ngOnInit(): void {
    this.preventBackButton();
    this.showTweets();
  }

}
