import { DataService } from '../../Services/data/data.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-exercises',
  templateUrl: './exercises.component.html',
  styleUrls: ['./exercises.component.css']
})
export class ExercisesComponent implements OnInit {

   constructor(private dataService:DataService,
              private router: Router) { }

  ngOnInit() {
  }

  createExercise(){
    this.router.navigate(['create-exercise']);
  }
  
editExercise(){
}

removeExercise(){
}
}
