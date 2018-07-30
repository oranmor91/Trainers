import { Component, OnInit } from '@angular/core';
import {GENDER} from "../../Model/gender.model";
import {TRAINER} from "../../Model/trainer.model";
import {DataService} from "../../Services/data/data.service";

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {

 trainer:TRAINER = new TRAINER();
 public gender : any = TRAINER;
  showError:boolean;
  errorMsg:string;

  constructor(private dataService:DataService) { }

  ngOnInit() {
  }

  register(){
    this.dataService.register(this.trainer)
      .subscribe((data)=>{
        console.log(data)
      },(err)=>{
        console.log(err)
        this.showError=true;
        this.errorMsg = err;
      },()=>{
        console.log('done')
      })
  }
}
