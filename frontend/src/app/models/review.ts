import { Game } from "./game";
import { User } from "./user";

export interface Review {
    id: number;
    rating: number;
    body: string;
    userId: number;
    gameId: number;
}