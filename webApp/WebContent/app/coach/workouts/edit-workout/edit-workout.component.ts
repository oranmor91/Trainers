import { EXERCISE } from '../../../Model/exercise.model';
import { WORKOUT } from '../../../Model/workout.model';
import { DataService } from '../../../Services/data/data.service';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-edit-workout',
  templateUrl: './edit-workout.component.html',
  styleUrls: ['./edit-workout.component.css']
})
export class EditWorkoutComponent implements OnInit {


/*
  exercises:EXERCISE[]=[{exerciseId:111, exerciseName:'a', mainMuscle:'legs', repeats:3, sets:2, note:'asas', weight:20},
    {exerciseId:222, exerciseName:'b', mainMuscle:'legs', repeats:3, sets:2, note:'asas', weight:20},
    {exerciseId:333, exerciseName:'c', mainMuscle:'legs', repeats:3, sets:2, note:'asas', weight:20}]
  exercise2:EXERCISE[]=[{exerciseId:111, exerciseName:'a', mainMuscle:'zain', repeats:3, sets:2, note:'asas', weight:20}]
  workout:WORKOUT={workoutId:111, workoutName:'sami', exercises:this.exercise2};
*/

    workoutId:string;
    workout:WORKOUT;
    exercises:EXERCISE[]=[];
    temp:EXERCISE[]=[];
    arr:number[]=[];
    arr2:number[]=[];

    constructor(private dataService:DataService,
              private router: Router,
              private route: ActivatedRoute) {
    this.workoutId = route.snapshot.params['id'];

  }

  ngOnInit() {
    this.getWorkout()
    this.getExercises()
  }

  getWorkout(){
      this.dataService.getWorkout(this.workoutId)
    .subscribe((data)=>{
    this.workout = <WORKOUT> data;
   },(err)=>{
      console.log(err)
    },()=>{
      console.log('done')
    })
  }

    getExercises() {
    this.dataService.getExercises(this.dataService.profile.id)
    .subscribe((data)=>{
    this.exercises = <EXERCISE[]> data;
   },(err)=>{
      console.log(err)
    },()=>{
      console.log('done')
    })
  }

  checkIfExisted(e:EXERCISE){
    console.log(e);
    console.log(this.workout);
    if(!this.workout.exercises || this.exercises.length == 0){
      console.log('no exercises found');
      return false;
    }

    this.arr = this.workout.exercises.map(exercise => exercise.exerciseId);

    console.log(this.arr);

    if(this.arr.includes(e.exerciseId)) {
        return true;
    } else {
      return false;
    }
  }

  onCheckChange($event, e:EXERCISE) {
    /* Selected */
    if($event.target.checked) {
      this.arr2 = this.temp.map(exercise => exercise.exerciseId);

      if (!this.arr2.includes(e.exerciseId)) {
        // Add a new control in the arrayForm
        this.temp.push({exerciseId:e.exerciseId, exerciseName:e.exerciseName, mainMuscle:e.mainMuscle, note:e.note, sets:e.sets, repeats:e.repeats, weight:e.weight});
        console.log('after push');
        console.log(this.temp);
      }
    }
    /* unselected */
    else{
      // find the unselected element
      let i: number = 0;
      this.temp.forEach((ctrl: EXERCISE) => {
        if(ctrl.exerciseId == e.exerciseId) {
          // Remove the unselected element from the arrayForm
          this.temp[i].exerciseId = 0;
          this.temp = this.temp.filter(exercise => exercise.exerciseId != 0);
          console.log('after remove');
          console.log(this.temp);
          return;
        }

        i++;
      });
    }
  }

  saveProgram(){
    this.dataService.createNewWorkout(this.dataService.profile.id, this.workout)
      .subscribe((data)=>{
      },(err)=>{
        console.log(err)
      },()=>{
        console.log('done')
      });

    this.workout.exercises = this.temp.slice();
    this.temp = [];
    console.log(this.temp);
    console.log(this.workout.exercises);
    location.reload();
  }
}
