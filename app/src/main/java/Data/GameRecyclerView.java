package Data;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cataloguedejeux.Details;
import com.example.cataloguedejeux.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import Model.Game;


public class GameRecyclerView {
    private Context context;
    private List<Game> gameList;
    public GameRecyclerView (Context context, List<Game> movies) {
        this.context=context;
        gameList=movies;
    }

    @NonNull

    public GameRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ///return null;
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.games,parent,false);
        return new ViewHolder(view,context);
    }


    public void onBindViewHolder(@NonNull GameRecyclerView.ViewHolder holder, int position) {
        Game game = gameList.get(position);
        String thumbnailLink = game.getThumbnail();

        holder.title.setText(game.getTitle());
        holder.type.setText(game.getGenre());

        Picasso.get()
                .load(thumbnailLink)
                .fit()
                .placeholder(android.R.drawable.ic_btn_speak_now)
                .into(holder.poster);
        holder.year.setText(game.getReleasedate());
    }


    public int getItemCount() {
        return gameList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView title;
        ImageView poster;
        TextView year;
        TextView type;

        public ViewHolder(@NonNull View itemView, final Context ctx)
        {
            super(itemView);
            context=ctx;

            title = itemView.findViewById(R.id.gametitleid);
            poster = itemView.findViewById(R.id.gameimgdis);
            year = itemView.findViewById(R.id.gamereleaseid);
            type = itemView.findViewById(R.id.gamegenreid);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Game game = gameList.get(getAdapterPosition());

                    Intent intent = new Intent(context, Details.class);

                    intent.putExtra("game", game);
                    ctx.startActivity(intent);



                }
            });
        }

        @Override
        public void onClick(View v) {

        }
    }
}
