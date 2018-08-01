import { WORKOUT } from './workout.model';
export class PROGRAM {
  programId:number;
  programName:string = '';
  programTarget:string = '';
  programNote:string = '';
  numOfExercises:number;
  workouts: WORKOUT[];
}
