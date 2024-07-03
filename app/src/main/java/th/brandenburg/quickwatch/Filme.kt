package th.brandenburg.quickwatch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


// TODO: Rename parameter arguments, choose names that match
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Filme.newInstance] factory method to
 * create an instance of this fragment.
 */
class Filme : Fragment(), MyAdapter.OnItemClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_filme, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as? MainActivity)?.backButton?.visibility = View.GONE

        val recyclerView: RecyclerView = view.findViewById(R.id.film_recycler_view)


        //Filme Einfügen
        val items: MutableList<Item> = ArrayList()
        items.add(Item("Die Verurteilten", "directed by Frank Darabont", R.drawable.titel_1))
        items.add(Item("Green Book", "directed by Peter Farelly", R.drawable.titel_3))
        items.add(Item("Jojo Rabbit", "directed by Taika Waititi", R.drawable.titel_4))
        items.add(Item("Three Billboard outside Ebbing, Missouri", "directed by Martin McDonagh", R.drawable.titel_5))

        //recyclerview mit Inhalten füllen
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = MyAdapter(requireContext(), items)
        val adapter = MyAdapter(requireContext(), items)
        adapter.setOnItemClickListener(this)
        recyclerView.adapter = adapter

    }

    override fun onItemClick(item: Item) {
        val filmDetailsFragment = FilmSpez()
        parentFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, filmDetailsFragment)
            .addToBackStack(null)
            .commit()
    }
}