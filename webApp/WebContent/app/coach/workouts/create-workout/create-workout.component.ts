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

/*  exercises:EXERCISE[]=[{id:111, name:'a', primaryMuscle:'legs', numOfIntervals:3, numOfSets:2, comment:'asas', weight:20},
    {id:222, name:'b', primaryMuscle:'legs', numOfIntervals:3, numOfSets:2, comment:'asas', weight:20},
    {id:333, name:'c', primaryMuscle:'legs', numOfIntervals:3, numOfSets:2, comment:'asas', weight:20}];*/


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
      this.arr2 = this.temp.map(exercise => exercise.id);

      if (!this.arr2.includes(e.id)) {
        // Add a new control in the arrayForm
        this.temp.push({id:e.id, name:e.name, primaryMuscle:e.primaryMuscle, comment:e.comment, numOfSets:e.numOfSets, numOfIntervals:e.numOfIntervals, weight:e.weight, videoURL:e.videoURL});
        console.log('after push');
        console.log(this.temp);
      }
    }
    /* unselected */
    else{
      // find the unselected element
      let i: number = 0;
      this.temp.forEach((ctrl: EXERCISE) => {
        if(ctrl.id == e.id) {
          // Remove the unselected element from the arrayForm
          this.temp[i].id = 0;
          this.temp = this.temp.filter(exercise => exercise.id != 0);
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
