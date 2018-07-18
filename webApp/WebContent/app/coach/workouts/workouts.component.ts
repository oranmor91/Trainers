import { DataService } from '../../Services/data/data.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-workouts',
  templateUrl: './workouts.component.html',
  styleUrls: ['./workouts.component.css']
})
export class WorkoutsComponent implements OnInit {

 constructor(private dataService:DataService,
              private router: Router) { }

  ngOnInit() {
  }

  createWorkout(){
    this.router.navigate(['create-workout']);
  }
  
  editWorkout(){
  }
  
  removeWorkout(){
    
  }
}
