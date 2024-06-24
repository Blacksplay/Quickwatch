package th.brandenburg.quickwatch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_filme, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.film_recycler_view)

        val items: MutableList<Item> = ArrayList()
        items.add(Item("Die Verurteilten", "Frank Darabont", R.drawable.titel_1))
        items.add(Item("Blues Brothers", "Bekannter Name", R.drawable.titel_1))
        items.add(Item("Luis Luis", "Ichabod Strauss", R.drawable.titel_1))
        items.add(Item("Film Nr 4", "Vierfahrt beachten", R.drawable.titel_1))


        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = MyAdapter(requireContext(), items)
        val adapter = MyAdapter(requireContext(), items)
        adapter.setOnItemClickListener(this)  // Set the click listener on the adapter
        recyclerView.adapter = adapter

    }

    override fun onItemClick(item: Item) {
        val filmDetailsFragment = FilmSpez()
        parentFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, filmDetailsFragment) // Replace with your fragment container ID
            .addToBackStack(null) // Optional: Add to back stack for navigation
            .commit()
    }
}