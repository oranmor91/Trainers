import { DataService } from '../../Services/data/data.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-programs',
  templateUrl: './programs.component.html',
  styleUrls: ['./programs.component.css']
})
export class ProgramsComponent implements OnInit {

 constructor(private dataService:DataService,
              private router: Router) { }

  ngOnInit() {
  }
createProgram(){
  this.router.navigate(['create-program']);
  }
  
  editProgram(){
    this.router.navigate(['edit-program']);
  }
   removeProgram(){
    this.router.navigate(['programs']);
  }
}
