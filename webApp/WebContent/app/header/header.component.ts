import { Component, OnInit } from '@angular/core';
import {DataService} from "../Services/data/data.service";
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(public dataService:DataService,  private router: Router) { }

  ngOnInit() {

  }

  logout(){
     this.dataService.logout()
    .subscribe((data)=>{
      this.router.navigate(['welcome']);
   },(err)=>{
      console.log(err)
    },()=>{
      console.log('done')
    })
  }
}
