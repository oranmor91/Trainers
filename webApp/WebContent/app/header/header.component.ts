import { Component, OnInit } from '@angular/core';
import {DataService} from "../Services/data/data.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(public dataService:DataService) { }

  ngOnInit() {

  }

  logout(){
     this.dataService.logout()
    .subscribe((data)=>{
   },(err)=>{
      console.log(err)
    },()=>{
      console.log('done')
    })
  }
}
