import { Component, OnInit } from '@angular/core';
import {DataService} from "../../Services/data/data.service";
import {ACCOUNT} from "../../Model/acount.model";
import {Router} from "@angular/router";
import {PROFILE} from "../../Model/profile.model";
import {profileMock} from "../../../mocks/profile/profile";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  account:ACCOUNT = new ACCOUNT();

  constructor(private dataService:DataService,
              private router: Router) { }


  ngOnInit() {
  }

  login(){
    this.dataService.login(this.account)
      .subscribe((data)=>{
        this.dataService.profile = <PROFILE>data;
        this.dataService.profile.type ==='coach' ? this.router.navigate(['programs']):this.router.navigate(['program']); //type trainer   
      },(err)=>{
        console.log(err)
        this.router.navigate(['programs']);  
      },()=>{
        console.log('done')
      })
  }
}
