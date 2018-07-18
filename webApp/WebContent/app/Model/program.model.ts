import { WORKOUT } from './workout.model';
export class PROGRAM {
  programName:string = '';
  programTarget:string = '';
  programNote:string = '';
  numOfExercises:number;
  workouts: [WORKOUT];
}