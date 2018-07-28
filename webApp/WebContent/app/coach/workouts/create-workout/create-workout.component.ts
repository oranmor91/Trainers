import { EXERCISE } from '../../../Model/exercise.model';
import { WORKOUT } from '../../../Model/workout.model';
import { DataService } from '../../../Services/data/data.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-workout',
  templateUrl: './create-workout.component.html',
  styleUrls: ['./create-workout.component.css']
})
export class CreateWorkoutComponent implements OnInit {

/*  exercises:EXERCISE[]=[{exerciseId:111, exerciseName:'a', mainMuscle:'legs', repeats:3, sets:2, note:'asas', weight:20},
    {exerciseId:222, exerciseName:'b', mainMuscle:'legs', repeats:3, sets:2, note:'asas', weight:20},
    {exerciseId:333, exerciseName:'c', mainMuscle:'legs', repeats:3, sets:2, note:'asas', weight:20}];*/


  workout:WORKOUT = new WORKOUT();
  exercises:EXERCISE[]=[];
  temp:EXERCISE[]=[];
  arr2:number[]=[];

 constructor(private dataService:DataService,
              private router: Router) { }

 ngOnInit() {
   this.getExercises();
  }

  getExercises(){
    this.dataService.getCoachExercise('')
    .subscribe((data)=>{
    this.exercises = <EXERCISE[]> data;
      },(err)=>{
        console.log(err)
      },()=>{
       console.log('done')
      })

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

  saveWorkout(){
        this.workout.exercises = this.temp;

        this.dataService.createNewWorkout(this.dataService.profile.id, this.workout)
      .subscribe((data)=>{
        this.router.navigate(['workouts']);
      },(err)=>{
        console.log(err)
      },()=>{
        console.log('done')
      })
  }
}
