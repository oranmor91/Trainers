import { DataService } from '../../Services/data/data.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-trainers',
  templateUrl: './trainers.component.html',
  styleUrls: ['./trainers.component.css']
})
export class TrainersComponent implements OnInit {

  constructor(private dataService:DataService,
              private router: Router) { }

  ngOnInit() {
  }
createTrainer(){
  this.router.navigate(['create-trainer']);
  }
  
  editTrainer(){
    this.router.navigate(['edit-trainer']);
  }
   removeTrainer(){
    this.router.navigate(['trainers']);
  }
}
